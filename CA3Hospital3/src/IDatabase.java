
public interface IDatabase {

	public void createPatientsDB();
	public void savePatientData(Patient p);
	public void updatePatientNurse(Patient p);
	public void updatePatientDoctor(Patient p);
}
