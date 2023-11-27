package writer_;

/**
 * @version 1.0
 * @Author Lee
 * @Date 2023/11/27 10:33
 */
public class Test_ {
    public static void main(String[] args) {
        BufferReader_ bufferReader = new BufferReader_(new FileReader_());
        bufferReader.reader01();
    }
}


abstract class Reader_ {
    public abstract void reader01();
}


class FileReader_ extends Reader_ {
    @Override
    public void reader01() {
        System.out.println("读取文件");
    }
}

class String_ extends Reader_ {
    @Override
    public void reader01() {
        System.out.println("读取字符串");
    }
}

class BufferReader_ extends Reader_{
    private Reader_ in;

    public BufferReader_(Reader_ in) {
        this.in = in;
    }

    @Override
    public void reader01() {
        in.reader01();
    }
}