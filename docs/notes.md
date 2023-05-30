- Spring framework scans all files for annotations and generates the objects and adds them to the application context,
  starting at the root package and working through all sub packages. If a class is defined with annotations outside
  the root package, then that class will not be analyzed by spring (by default)
- When adding a new project to a directory and having multiple projects in the same intellij session,
  be sure to click the + in the Maven tab to add a new Maven profile for the new project.
- To run multiple instances of a project, go to:
  Run -> Edit Configurations -> Select project -> Modify Options -> Allow Multiple Instances
- No args constructor on aggregate is used at startup to build current state of aggregate from events
- To access the h2 database navigate to the ApiGateway instance followed by the path to the microservice (products-service)
  and then h2-console. So for this project running locally its: http://localhost:8082/products-service/h2-console
- Links to hibernate validator documentation:
  - http://hibernate.org/validator/
  - http://hibernate.org/validator/documentation/
- Processing group is used to group event handlers together. By default, uses package to map them together, so if your
  event handlers that should be in the same processing group are in different packages you should group them together
  with the @ProcessingGroup annotation. Putting event handlers in the same processing group puts them into the same 
  thread and uses a tracking token to ensure that the events are only handled once within that thread.