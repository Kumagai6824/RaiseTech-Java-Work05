public class NoSuchKeyException extends Throwable {
    public String errMsg;

    public NoSuchKeyException(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
