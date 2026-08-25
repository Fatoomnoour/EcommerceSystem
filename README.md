# EcommerceSystem

A small Java demonstration of products, stock, a cart, shipping fees, and checkout. It is an educational console application, not a production commerce system.

## Requirements

Java 11 or newer is recommended. No third-party dependencies are required.

## Build and run

```bash
make build
make run
make test
make clean
```

Without Make:

```bash
mkdir -p build/classes
javac -d build/classes src/*.java
java -cp build/classes Main
```

## Known limitations

The example currently uses `double` for money, has no persistence, authentication, payment integration, concurrency control, or automated unit tests. Before production use, replace floating-point money with integer minor units or `BigDecimal`, add domain validation, and introduce unit and integration tests. Generated build output is intentionally ignored by Git.
