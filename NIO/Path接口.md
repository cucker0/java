Path接口
==

# 抽象方法
```text
default boolean	endsWith​(String other)	
Tests if this path ends with a Path, constructed by converting the given path string, in exactly the manner specified by the endsWith(Path) method.

boolean	endsWith​(Path other)	
Tests if this path ends with the given path.

boolean	equals​(Object other)	
Tests this path for equality with the given object.

Path	getFileName()	
Returns the name of the file or directory denoted by this path as a Path object.

FileSystem	getFileSystem()	
Returns the file system that created this object.

Path	getName​(int index)	
Returns a name element of this path as a Path object.

int	getNameCount()	
Returns the number of name elements in the path.

Path	getParent()	
Returns the parent path, or null if this path does not have a parent.

Path	getRoot()	
Returns the root component of this path as a Path object, or null if this path does not have a root component.

int	hashCode()	
Computes a hash code for this path.

boolean	isAbsolute()	
Tells whether or not this path is absolute.

default Iterator<Path>	iterator()	
Returns an iterator over the name elements of this path.

Path	normalize()	
Returns a path that is this path with redundant name elements eliminated.

static Path	of​(String first, String... more)	
Returns a Path by converting a path string, or a sequence of strings that when joined form a path string.

static Path	of​(URI uri)	
Returns a Path by converting a URI.

default WatchKey	register​(WatchService watcher, WatchEvent.Kind<?>... events)	
Registers the file located by this path with a watch service.

WatchKey	register​(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers)	
Registers the file located by this path with a watch service.

Path	relativize​(Path other)	
Constructs a relative path between this path and a given path.

default Path	resolve​(String other)	
Converts a given path string to a Path and resolves it against this Path in exactly the manner specified by the resolve method.

Path	resolve​(Path other)	
Resolve the given path against this path.

default Path	resolveSibling​(String other)	
Converts a given path string to a Path and resolves it against this path's parent path in exactly the manner specified by the resolveSibling method.

default Path	resolveSibling​(Path other)	
Resolves the given path against this path's parent path.

default boolean	startsWith​(String other)	
Tests if this path starts with a Path, constructed by converting the given path string, in exactly the manner specified by the startsWith(Path) method.

boolean	startsWith​(Path other)	
Tests if this path starts with the given path.

Path	subpath​(int beginIndex, int endIndex)	
Returns a relative Path that is a subsequence of the name elements of this path.

Path	toAbsolutePath()	
Returns a Path object representing the absolute path of this path.

default File	toFile()	
Returns a File object representing this path.

Path	toRealPath​(LinkOption... options)	
Returns the real path of an existing file.


URI	toUri()	
Returns a URI to represent this path.

int	compareTo​(Path other)	
Compares two abstract paths lexicographically.

String	toString()	
Returns the string representation of this path.
```