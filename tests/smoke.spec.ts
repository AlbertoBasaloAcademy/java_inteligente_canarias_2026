import { test, expect } from '@playwright/test';

test.describe('Smoke Tests', () => {
  test('should verify API health status endpoint', async ({ request }) => {
    // Arrange & Act
    const response = await request.get('/api/health/status');

    // Assert
    expect(response.status()).toBe(200);
    const data = await response.json();
    expect(data).toMatchObject({
      status: 'UP',
      message: expect.any(String),
      timestamp: expect.any(Number),
      version: expect.any(String),
    });
  });

  test('should verify hello endpoint', async ({ request }) => {
    // Arrange & Act
    const response = await request.get('/api/hello');

    // Assert
    expect(response.status()).toBe(200);
    const text = await response.text();
    expect(text).toContain('Hello from Spring Boot!');
  });

  test('should return 404 for non-existent endpoint', async ({ request }) => {
    // Arrange & Act
    const response = await request.get('/api/nonexistent', {
      failOnStatusCode: false,
    });

    // Assert
    expect(response.status()).toBe(404);
  });

  test('should have correct content type headers', async ({ request }) => {
    // Arrange & Act
    const response = await request.get('/api/health/status');

    // Assert
    expect(response.headers()['content-type']).toContain('application/json');
  });
});
