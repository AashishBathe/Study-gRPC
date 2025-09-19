# gRPC Hello World with Spring Boot

This project is a simple demonstration of **inter-service communication using gRPC in Spring Boot**.

It consists of three modules:

1. **grpc-interface** – contains the `.proto` file and generated Java stubs (via Maven).
2. **filler-service** – a gRPC server that responds with the word `"world"`.
3. **hello-service** – a REST API (`GET /hello`) that makes a gRPC call to the filler-service and returns `"Hello world"`.

## How it works

* The `hello-service` calls `filler-service` using a generated gRPC stub.
* The `.proto` file defines the contract for communication.
* gRPC (with Protocol Buffers over HTTP/2) provides **fast, strongly typed, and efficient** communication compared to traditional REST.

## Running the project

1. Start the **filler-service** (`mvn spring-boot:run` on port `9090`).
2. Start the **hello-service** (`mvn spring-boot:run` on port `8000`).
3. Test the endpoint:

   ```bash
   curl http://localhost:8000/hello
   ```

   Response:

   ```
   Hello world
   ```

This is a foundational example to understand gRPC in Spring Boot. The setup can be extended into more advanced, production-grade inter-service communication. 🚀
