# Linux script to build the java file (in case you use the command line). Run this in the src folder

classpath=".:./internet_manager/:./country"

# This project needs the jar file of Gson (link in readme)

# Append the path to the gson jar files in the $classpath variable given here

classpath="${classpath}:${path-to-gson-jar}"

# Or you can opt for the easer method of using an IDE (I'd recommend this)

java -cp "$classpath" Main