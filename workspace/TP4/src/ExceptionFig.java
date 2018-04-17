class ExceptionFig extends Exception {
	String type;

	public ExceptionFig(String type, String msg) {
		super(type + " - " + msg);
		this.type = type;
	}
}