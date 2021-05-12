@bean(id = "myTeacher")
public class myTeacher extends teacher{

	@inject
	public student student;
	void getStudent(student student) {
		this.student = student;
	}
	void teach() {
		this.student.learning();
	}
}
