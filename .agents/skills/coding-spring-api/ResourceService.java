import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class ResourceService {

  private final ResourceRepository resourceRepository;
  private final ResourceMapper resourceMapper;

  public ResourceService(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
    this.resourceRepository = resourceRepository;
    this.resourceMapper = resourceMapper;
  }

  /**
   * Retrieves all resources
   */
  @Transactional(readOnly = true)
  public List<ResourceResponse> getAll() {
    return resourceRepository.findAll()
      .stream()
      .map(resourceMapper:: toResponse)
      .toList();
  }

  /**
   * Retrieves a resource by ID
   * Throws ResourceNotFoundException if not found
   */
  @Transactional(readOnly = true)
  public ResourceResponse getById(String id) {
        Resource entity = findOrThrow(id);
    return resourceMapper.toResponse(entity);
  }

  /**
   * Creates a new resource
   */
  @Transactional
  public ResourceResponse create(CreateResourceRequest request) {
        Resource entity = resourceMapper.toEntity(request);
    entity.setCreatedAt(Instant.now());
    entity.setUpdatedAt(Instant.now());

        Resource saved = resourceRepository.save(entity);
    return resourceMapper.toResponse(saved);
  }

  /**
   * Updates an existing resource
   * Throws ResourceNotFoundException if not found
   */
  @Transactional
  public ResourceResponse update(String id, UpdateResourceRequest request) {
        Resource existing = findOrThrow(id);

    if (request.name() != null) {
      existing.setName(request.name());
    }
    if (request.status() != null) {
      existing.setStatus(request.status());
    }
    if (request.capacity() != null) {
      existing.setCapacity(request.capacity());
    }
    existing.setUpdatedAt(Instant.now());

        Resource saved = resourceRepository.save(existing);
    return resourceMapper.toResponse(saved);
  }

  /**
   * Deletes a resource
   * Throws ResourceNotFoundException if not found
   */
  @Transactional
  public void delete(String id) {
        Resource existing = findOrThrow(id);
    resourceRepository.delete(existing);
  }

  private Resource findOrThrow(String id) {
    return resourceRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Resource %s not found".formatted(id)));
  }

  public List<FieldError> validateForCreate(CreateResourceRequest request) {
    List<FieldError> errors = new java.util.ArrayList<>();

    if (request == null) {
      errors.add(new FieldError("body", "Request body is required"));
      return errors;
    }

    if (request.name() == null || request.name().isBlank()) {
      errors.add(new FieldError("name", "name is required"));
    } else if (request.name().length() > 120) {
      errors.add(new FieldError("name", "name must be at most 120 characters"));
    }

    if (request.status() == null) {
      errors.add(new FieldError("status", "status is required"));
    }

    if (request.capacity() != null && request.capacity() < 1) {
      errors.add(new FieldError("capacity", "capacity must be greater than 0"));
    }

    return errors;
  }

  public List<FieldError> validateForUpdate(UpdateResourceRequest request) {
    List<FieldError> errors = new java.util.ArrayList<>();

    if (request == null) {
      errors.add(new FieldError("body", "Request body is required"));
      return errors;
    }

    if (request.name() != null && (request.name().isBlank() || request.name().length() > 120)) {
      errors.add(new FieldError("name", "name must be between 1 and 120 characters"));
    }

    if (request.capacity() != null && request.capacity() < 1) {
      errors.add(new FieldError("capacity", "capacity must be greater than 0"));
    }

    return errors;
  }
}
