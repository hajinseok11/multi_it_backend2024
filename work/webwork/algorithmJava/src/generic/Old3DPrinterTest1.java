package generic;

public class Old3DPrinterTest1 {
	public static void main(String[] args) {
		Aluminum aluminum = new Aluminum();
		OldThreeDPrinter1 printer = new OldThreeDPrinter1();
		// instanceof로 타입을 검사하는 체크
		printer.setMaterial(aluminum); // Object라 문제없음
		Aluminum al = (Aluminum)printer.getMaterial();
	}

}
