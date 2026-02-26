import java.time.Instant;
import java.util.List;

/**
 * Domain enum
 */
public enum ResourceStatus {
  ACTIVE,
  INACTIVE,
  RETIRED
}

/**
 * Domain entity - represents a resource as stored in the system
 */
public class Resource {
  private String id;
  private String name;
  private ResourceStatus status;
  private Integer capacity;
  private Instant createdAt;
  private Instant updatedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResourceStatus getStatus() {
    return status;
  }

  public void setStatus(ResourceStatus status) {
    this.status = status;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }
}

/**
 * Request DTO for creating a new resource
 */
public record CreateResourceRequest(
    String name,
    ResourceStatus status,
    Integer capacity) {
}

/**
 * Request DTO for updating an existing resource
 * All fields are optional
 */
public record UpdateResourceRequest(
    String name,
    ResourceStatus status,
    Integer capacity) {
}

/**
 * Response DTO exposed by API
 */
public record ResourceResponse(
    String id,
    String name,
    ResourceStatus status,
    Integer capacity,
    Instant createdAt,
    Instant updatedAt) {
}

/**
 * Validation field error
 */
public record FieldError(
    String field,
    String message) {
}

/**
 * Standard error response format
 */
public record ErrorResponse(
    String code,
    String message,
    List<FieldError> fieldErrors) {
}
