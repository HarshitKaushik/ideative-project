# How to contibute
Please make sure you follow the following coding conventions (inspired by Google style guide)
### Source files basics
- The source file name consists of the case-sensitive name of the top-level class it contains (of which there is exactly one), plus the .java extension.
- Source files are encoded in UTF-8.
- Aside from the line terminator sequence, the ASCII horizontal space character (0x20) is the only whitespace character that appears anywhere in a source file.
- Tab characters are **not** used for indentation.
- For any character that has a special escape sequence (\b, \t, \n, \f, \r, \", \' and \\), that sequence is used rather than the corresponding octal (e.g. \012) or Unicode (e.g. \u000a) escape.

### Source File Structure
- **Exactly one blank line** separates each section that is present.
- If license or copyright information belongs in a file, it belongs here.
- Import statements are not line-wrapped. The column limit does not apply to import statements.
- Static import is not used for static nested classes. They are imported with normal imports.
- Each top-level class resides in a source file of its own.
- When a class has multiple constructors, or multiple methods with the same name, these appear sequentially, with no other code in between (not even private members).

### Formatting
- Braces are used with if, else, for, do and while statements, even when the body is empty or contains only a single statement.
- Braces follow the Kernighan and Ritchie style ("Egyptian brackets") for nonempty blocks and block-like constructs.
- Each time a new block or block-like construct is opened, the indent increases by two spaces. When the block ends, the indent returns to the previous indent level. The indent level applies to both code and comments throughout the block.
- Each statement is followed by a line break.
- Java code has a column limit of 100 characters. Except as noted below, any line that would exceed this limit must be line-wrapped.
- When line-wrapping, each line after the first (each continuation line) is indented at least +4 from the original line.
- Multiple consecutive blank lines are permitted, but never required (or encouraged).

### Horizontal whitespace
Beyond where required by the language or other style rules, and apart from literals, comments and Javadoc, a single ASCII space also appears in the following places only.
- Separating any reserved word, such as if, for or catch, from an open parenthesis (() that follows it on that line
- Separating any reserved word, such as else or catch, from a closing curly brace (}) that precedes it on that line
- On both sides of any binary or ternary operator.
- After ,:; or the closing parenthesis ()) of a cast.
- On both sides of the double slash (//) that begins an end-of-line comment. Here, multiple spaces are allowed, but not required.
- Between the type and variable of a declaration.

### Other rules
- Every variable declaration (field or local) declares only one variable: declarations such as ``` int a, b; ```are not used.
- Local variables are not habitually declared at the start of their containing block or block-like construct. Instead, local variables are declared close to the point they are first used (within reason), to minimize their scope. Local variable declarations typically have initializers, or are initialized immediately after declaration.
- Annotations applying to a class, method or constructor appear immediately after the documentation block, and each annotation is listed on a line of its own (that is, one annotation per line). These line breaks do not constitute line-wrapping, so the indentation level is not increased. 
- Comments are not enclosed in boxes drawn with asterisks or other characters.
- Class and member modifiers, when present, appear in the order recommended by the Java Language Specification: 
```
public protected private abstract default static final transient volatile synchronized native strictfp
```
