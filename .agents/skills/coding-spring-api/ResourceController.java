import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    /**
     * GET /api/resources
     * Retrieves all resources
     */
    @GetMapping
    public ResponseEntity<List<ResourceResponse>> getAll() {
        return ResponseEntity.ok(resourceService.getAll());
    }

    /**
     * GET /api/resources/{id}
     * Retrieves a single resource by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(resourceService.getById(id));
    }

    /**
     * POST /api/resources
     * Creates a new resource
     * Returns 201 on success, 400 on validation error
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateResourceRequest request) {
        List<FieldError> errors = resourceService.validateForCreate(request);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("VALIDATION_ERROR", "Invalid request payload", errors));
        }

        ResourceResponse created = resourceService.create(request);
        URI location = URI.create("/api/resources/" + created.id());
        return ResponseEntity.created(location).body(created);
    }

    /**
     * PUT /api/resources/{id}
     * Updates an existing resource
     * Returns 200 on success, 400 on validation error, 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable String id,
            @RequestBody UpdateResourceRequest request
    ) {
        List<FieldError> errors = resourceService.validateForUpdate(request);
        if (!errors.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("VALIDATION_ERROR", "Invalid request payload", errors));
        }

        return ResponseEntity.ok(resourceService.update(id, request));
    }

    /**
     * DELETE /api/resources/{id}
     * Deletes a resource
     * Returns 204 No Content on success
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        resourceService.delete(id);
    }
}
