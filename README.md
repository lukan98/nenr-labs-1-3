# Fuzzy Sets and Fuzzy Boat Controller (NENR Labs 1–3)

Java implementations of fuzzy-set fundamentals and a fuzzy inference system, written for the **NENR (Fuzzy, Evolutionary and Neurocomputing)** course at FER, University of Zagreb.

## Contents

- **Fuzzy domains and sets**: simple/composite domains, mutable and calculated fuzzy sets, lambda and standard membership functions
- **Fuzzy operations**: unary operations, Zadeh/Hamacher t-norms and s-norms, binary operations on fuzzy sets
- **Fuzzy relations**: composition and relation properties
- **Fuzzy inference system**: rule bases, defuzzification with the centre-of-area method, and a boat controller that computes acceleration and rudder commands from sensor inputs

## Requirements

- Java JDK 11 or newer
- Eclipse is optional; the repository includes Eclipse project metadata

## Build

From the project root:

```bash
mkdir -p bin
find src -name "*.java" -print0 | xargs -0 javac -d bin
```

## Run the demos

Fuzzy-set and relation examples:

```bash
java -cp bin hr.fer.zemris.fuzzy.demo.vjezba1.Primjer1
java -cp bin hr.fer.zemris.fuzzy.demo.vjezba1.Primjer2
java -cp bin hr.fer.zemris.fuzzy.demo.vjezba2.Primjer1
java -cp bin hr.fer.zemris.fuzzy.demo.vjezba2.Primjer2
java -cp bin hr.fer.zemris.fuzzy.demo.vjezba2.Primjer3
```

Boat controller (lab 3):

```bash
java -cp bin hr.fer.zemris.fuzzy.demo.vjezba3.Main
```

The controller reads one line per simulation step from standard input:

```text
L D LK DK V S
```

where `L`, `D`, `LK`, `DK`, `V` and `S` are the sensor readings. It writes the computed acceleration and rudder command:

```text
akcel kormilo
```

Send a line beginning with `K` to stop.

## Project structure

```text
src/hr/fer/zemris/fuzzy/
├── *.java              # domains, fuzzy sets, operations, relations
├── demo/vjezba1/       # fuzzy-set examples
├── demo/vjezba2/       # relation examples
├── demo/vjezba3/       # boat controller entry point
└── system/             # rule bases, defuzzifier and fuzzy systems
```
