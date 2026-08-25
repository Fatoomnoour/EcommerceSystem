JAVAC ?= javac
BUILD_DIR := build/classes
TEST_DIR := build/test-classes
SOURCES := $(wildcard src/*.java)
TESTS := $(wildcard tests/*.java)

.PHONY: build run clean test
build:
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -d $(BUILD_DIR) $(SOURCES)

run: build
	java -cp $(BUILD_DIR) Main

test: build
	mkdir -p $(TEST_DIR)
	$(JAVAC) -cp $(BUILD_DIR) -d $(TEST_DIR) $(TESTS)
	java -ea -cp $(BUILD_DIR):$(TEST_DIR) ProductTest

clean:
	rm -rf build
