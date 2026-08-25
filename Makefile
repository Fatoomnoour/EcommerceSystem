JAVAC ?= javac
BUILD_DIR := build/classes
SOURCES := $(wildcard src/*.java)

.PHONY: build run clean test
build:
	mkdir -p $(BUILD_DIR)
	$(JAVAC) -d $(BUILD_DIR) $(SOURCES)

run: build
	java -cp $(BUILD_DIR) Main

test: build
	@echo "No automated tests are defined yet; main scenario compiled successfully."

clean:
	rm -rf build
