- Spring framework scans all files for annotations and generates the objects and adds them to the application context,
  starting at the root package and working through all sub packages. If a class is defined with annotations outside of
  the root package, then that class will not be analyzed by spring (by default)
- 