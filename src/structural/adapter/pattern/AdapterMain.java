package structural.adapter.pattern;

/**
 * Adapter patterns lets you make you wrap an incompatible object into an adapter
 * to make it compatible with another object. <p>
 * Used in libraries : <p>
 * Arrays.asList <br>
 * Collections.list() <br>
 * MvcConfigurerAdapter <br>
 * MouseAdapter <br>
 * HandlerAdapter <br>
 */

//Library code
//Client
class FileCompressorAndDispatcher {
    public static void compressAndDispatch(BinaryFile compressableBinaryFile) {
        System.out.println("compressing ...");
        compressableBinaryFile.compress();
        System.out.println("dispatching...");
        System.out.println("done\n");
    }
}

interface BinaryFile {
    void compress();
}

/**
 * There are many binary file types they already compress
 */
class ImageFile implements BinaryFile {
    @Override
    public void compress() {
        System.out.println("ImageFile.compress");
    }
}

class MusicFile implements BinaryFile {
    @Override
    public void compress() {
        System.out.println("MusicFile.compress");
    }
}

/**
 * end user
 * We can use interface for TextFile for more flexiblity
 */

class TextFile {
    public void compress() {
        System.out.println("TextFile.compress");
    }
}

/**
 * This is adapter class which will convert our Text file to BinaryFile type
 */
class TextFileAdapter implements BinaryFile {
    TextFile textFile;

    public TextFileAdapter(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public void compress() {
        textFile.compress();
    }
}

/**
 * Main Class
 */
public class AdapterMain {
    public static void main(String[] args) {
        //compressing and dispatching image file...
        BinaryFile binaryFile = new ImageFile();
        FileCompressorAndDispatcher.compressAndDispatch(binaryFile);

        //compressing and dispatching text file...
        //Here we can use interface of TextFile for more flexiblity
        TextFile textFile = new TextFile();
        TextFileAdapter textFileAdapter = new TextFileAdapter(textFile);
        FileCompressorAndDispatcher.compressAndDispatch(textFileAdapter);
    }
}

