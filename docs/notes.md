- Spring framework scans all files for annotations and generates the objects and adds them to the application context,
  starting at the root package and working through all sub packages. If a class is defined with annotations outside of
  the root package, then that class will not be analyzed by spring (by default)
- When adding a new project to a directory and having multiple projects in the same intellij session,
  be sure to click the + in the Maven tab to add a new Maven profile for the new project.
- To run multiple instances of a project, go to:
  Run -> Edit Configurations -> Select project -> Modify Options -> Allow Multiple Instances
- No args constructor on aggregate is used at startup to build current state of aggregate from events