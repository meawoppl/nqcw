# nqcw
N-Queens with colinearity restriction for CompilerWorks


## Usage
To run:
```bash
./gradlew run
```

To change the board size (for n=10):
```bash
./gradlew run --args="10"
```

To run the traditional N-Queens, add the -t flag:
```bash
./gradlew run --args="10 -t"
```


## Docs and Implementation Notes
```bash
./gradlew javadoc && google-chrome build/docs/javadoc/index.html
```

## Tests
```bash
./gradlew test
```
