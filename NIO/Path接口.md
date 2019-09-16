Path接口
==

# 抽象方法
```text
default boolean endsWith​(String other) 
Tests if this path ends with a Path, constructed by converting the given path string, in exactly the manner specified by the endsWith(Path) method.
判断此Path对象是否以字符串other结尾

boolean endsWith​(Path other) 
Tests if this path ends with the given path.
判断此Path对象是否以Path对象other开头结尾

default boolean startsWith​(String other) 
Tests if this path starts with a Path, constructed by converting the given path string, in exactly the manner specified by the startsWith(Path) method.
判断此Path对象是否以字符串other开头

boolean startsWith​(Path other) 
Tests if this path starts with the given path.
判断此Path对象是否以Path对象other开头

boolean equals​(Object other) 
Tests this path for equality with the given object.
判断此Path对象与Object对象other是否相等

Path getFileName() 
Returns the name of the file or directory denoted by this path as a Path object.
返回此Path对象的最后一层的Path对象

FileSystem getFileSystem() 
Returns the file system that created this object.
返回创建此对象的文件系统，如：sun.nio.fs.WindowsFileSystem@43a25848

Path getName​(int index) 
Returns a name element of this path as a Path object.

int getNameCount() 
Returns the number of name elements in the path.
返回Path 根目录后面元素的数量(即path的层数)

Path getParent() 
Returns the parent path, or null if this path does not have a parent.
返回Path对象包含整个路径，不包含 Path 对象指定的文件路径

Path getRoot() 
Returns the root component of this path as a Path object, or null if this path does not have a root component.
返回调用 Path 对象的根路径

boolean isAbsolute() 
Tells whether or not this path is absolute.
判断是否是绝对路径

default Iterator<Path> iterator() 
Returns an iterator over the name elements of this path.
返回此Path对象每层path组成的Iterator

Path normalize() 
Returns a path that is this path with redundant name elements eliminated.

static Path of​(String first, String... more) 
Returns a Path by converting a path string, or a sequence of strings that when joined form a path string.
创建一个由一个或多个字符串组成的Path对象

static Path of​(URI uri) 
Returns a Path by converting a URI.
创建一个由uri组成的Path对象。只能解析file文件系统资源，无法解析URL资源。
如：Path path2 = Path.of(URI.create("file:///C:/Windows/System32/drivers/etc/hosts"));

default WatchKey register​(WatchService watcher, WatchEvent.Kind<?>... events) 
Registers the file located by this path with a watch service.


WatchKey register​(WatchService watcher, WatchEvent.Kind<?>[] events, WatchEvent.Modifier... modifiers) 
Registers the file located by this path with a watch service.

Path relativize​(Path other) 
Constructs a relative path between this path and a given path.

default Path resolve​(String other) 
Converts a given path string to a Path and resolves it against this Path in exactly the manner specified by the resolve method.

Path resolve​(Path other) 
Resolve the given path against this path.
返回根据此路径解析给定Path other的Path，返回此对象后面追加Path other合成后的新Path对象

default Path resolveSibling​(String other) 
Converts a given path string to a Path and resolves it against this path's parent path in exactly the manner specified by the resolveSibling method.

default Path resolveSibling​(Path other) 
Resolves the given path against this path's parent path.

Path subpath​(int beginIndex, int endIndex) 
Returns a relative Path that is a subsequence of the name elements of this path.

Path toAbsolutePath() 
Returns a Path object representing the absolute path of this path.
返回此Path对象的绝对路径的Path对象

default File toFile() 
Returns a File object representing this path.
返回表示此Path对象的File对象

Path toRealPath​(LinkOption... options) 
Returns the real path of an existing file.


URI toUri() 
Returns a URI to represent this path.

int compareTo​(Path other) 
Compares two abstract paths lexicographically.

String toString() 
Returns the string representation of this path.

int hashCode() 
Computes a hash code for this path.
```