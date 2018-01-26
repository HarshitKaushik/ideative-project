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

## Naming
### Rules common to all identifiers
- Identifiers use only ASCII letters and digits, and, in a small number of cases noted below, underscores. Thus each valid identifier name is matched by the regular expression \w+ . Few like name_, mName, s_name and kName, are not used.
## Rules by identifier type
### Package names
- Package names are all lowercase, with consecutive words simply concatenated together (no underscores). For example, com.example.deepspace, not com.example.deepSpace or com.example.deep_space.
###  Class names
- Class names are written in UpperCamelCase.
- Class names are typically nouns or noun phrases. For example, Character or ImmutableList. Interface names may also be nouns or noun phrases (for example, List), but may sometimes be adjectives or adjective phrases instead (for example, Readable).
### Method names
- Method names are written in lowerCamelCase.
- Method names are typically verbs or verb phrases. For example, sendMessage or stop.
- Underscores may appear in JUnit test method names to separate logical components of the name. One typical pattern is test<MethodUnderTest>_<state>, for example testPop_emptyStack. There is no One Correct Way to name test methods.
### Constant names
- Constant names use CONSTANT_CASE: all uppercase letters, with words separated by underscores.
### Non-constant field names
- Non-constant field names (static or otherwise) are written in lowerCamelCase.
### Parameter names
- Parameter names are written in lowerCamelCase.
- One-character parameter names in public methods should be avoided.
### Local variable names
- Local variable names are written in lowerCamelCase.
- Even when final and immutable, local variables are not considered to be constants, and should not be styled as constants.
### Type variable names
- Each type variable is named in one of two styles:
- A single capital letter, optionally followed by a single numeral (such as E, T, X, T2)
A name in the form used for classes (see Section 5.2.2, Class names), followed by the capital letter T (examples: RequestT, FooBarT).

## Programming Practices
## @Override: always used
- A method is marked with the @Override annotation whenever it is legal. This includes a class method overriding a superclass method, a class method implementing an interface method, and an interface method respecifying a superinterface method.
Exception: @Override may be omitted when the parent method is @Deprecated.
## Caught exceptions: not ignored
- Except as noted below, it is very rarely correct to do nothing in response to a caught exception. (Typical responses are to log it, or if it is considered "impossible", rethrow it as an AssertionError.)
When it truly is appropriate to take no action whatsoever in a catch block, the reason this is justified is explained in a comment.
## Static members: qualified using class
- When a reference to a static class member must be qualified, it is qualified with that class's name, not with a reference or expression of that class's type.
```.java
Foo aFoo = ...;
Foo.aStaticMethod(); // good
aFoo.aStaticMethod(); // bad
somethingThatYieldsAFoo().aStaticMethod(); // very bad
```
## Finalizers: not used
- It is extremely rare to override Object.finalize.

# Javadoc
## Formatting
### General form
- The basic formatting of Javadoc blocks is as seen in this example:
```.java
/**
 *Multiple lines of Javadoc text are written here,
 *wrapped normally...
*/
public int method(String p1) { ... }
... or in this single-line example:
/** An especially short bit of Javadoc. */
```
- The basic form is always acceptable. The single-line form may be substituted when the entirety of the Javadoc block (including comment markers) can fit on a single line. Note that this only applies when there are no block tags such as @return.
###  Paragraphs
- One blank line�that is, a line containing only the aligned leading asterisk (*)�appears between paragraphs, and before the group of block tags if present. Each paragraph but the first has <p> immediately before the first word, with no space after.
### Block tags
- Any of the standard "block tags" that are used appear in the order @param, @return, @throws, @deprecated, and these four types never appear with an empty description. When a block tag doesn't fit on a single line, continuation lines are indented four (or more) spaces from the position of the @.
## The summary fragment
- Each Javadoc block begins with a brief summary fragment. This fragment is very important: it is the only part of the text that appears in certain contexts such as class and method indexes.
- This is a fragment�a noun phrase or verb phrase, not a complete sentence. It does not begin with A {@code Foo} is a..., or This method returns..., nor does it form a complete imperative sentence like Save the record.. However, the fragment is capitalized and punctuated as if it were a complete sentence.
## Where Javadoc is used
- At the minimum, Javadoc is present for every public class, and every public or protected member of such a class, with a few exceptions noted below.
- Additional Javadoc content may also be present, as explained in Section Non-required Javadoc.
### Exception: self-explanatory methods
- Javadoc is optional for "simple, obvious" methods like getFoo, in cases where there really and truly is nothing else worthwhile to say but "Returns the foo".
- -Important: it is not appropriate to cite this exception to justify omitting relevant information that a typical reader might need to know. For example, for a method named getCanonicalName, don't omit its documentation (with the rationale that it would say only /** Returns the canonical name. */) if a typical reader may have no idea what the term "canonical name" means!
### Exception: overrides
- Javadoc is not always present on a method that overrides a supertype method.
### Non-required Javadoc
- Other classes and members have Javadoc as needed or desired.
- Whenever an implementation comment would be used to define the overall purpose or behavior of a class or member, that comment is written as Javadoc instead (using /**).
- Non-required Javadoc is not strictly required to follow the formatting rules of Sections Paragraphs, Block tags, and The summary fragment, though it is of course recommended.