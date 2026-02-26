
### Install Ollama

https://ollama.com/download

```powershell
irm https://ollama.com/install.ps1 | iex
```

### Run Ollama with qwen3:4b
```bash
ollama list
ollama pull qwen3:4b
ollama run qwen3:4b
ollama pull nomic-embed-text
```

```bash
curl http://localhost:11434/api/chat  -d '{ "model": "qwen3:8b","think": false,  "stream": false, "messages": [{"role": "system", "content": "No introductions. No conclusions. Stay concise at all times."}, {"role": "user", "content": "Hello!"}] }'

curl http://localhost:11434/api/chat  -d '{ "model": "qwen3:8b","think": false,  "stream": false, "messages": [{"role": "system", "content": "No introductions. No conclusions. Stay concise at all times."}, {"role": "user", "content": "What color is the sky?"}] }'

curl http://localhost:11434/api/chat  -d '{ "model": "qwen3:8b","think": false,  "stream": false, "messages": [{"role": "system", "content": "No introductions. No conclusions. Stay concise at all times."}, {"role": "user", "content": "What is mars?"}] }'

curl http://localhost:11434/api/chat  -d '{ "model": "qwen3:8b","think": false,  "stream": false, "messages": [{"role": "system", "content": "No introductions. No conclusions. Stay concise at all times."}, {"role": "user", "content": "What is 3I/ATLAS?"}] }'
```