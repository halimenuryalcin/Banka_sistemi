import java.sql.Time;

public class kayit {
	int id;
	Long kaynakId;
	Long hedefId;
	String islem;
	int tutar;
	int kbakiye;
	int hbakiye;
	Time tarih;
	public Long getKaynakId() {
		return kaynakId;
	}
	public void setKaynakId(Long kaynakId) {
		this.kaynakId = kaynakId;
	}
	public Long getHedefId() {
		return hedefId;
	}
	public void setHedefId(Long hedefId) {
		this.hedefId = hedefId;
	}
	public String getIslem() {
		return islem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIslem(String islem) {
		this.islem = islem;
	}
	public int getTutar() {
		return tutar;
	}
	public void setTutar(int tutar) {
		this.tutar = tutar;
	}
	public int getKbakiye() {
		return kbakiye;
	}
	public void setKbakiye(int kbakiye) {
		this.kbakiye = kbakiye;
	}
	public int getHbakiye() {
		return hbakiye;
	}
	public void setHbakiye(int hbakiye) {
		this.hbakiye = hbakiye;
	}
	public Time getTarih() {
		return tarih;
	}
	public void setTarih(Time time) {
		this.tarih = time;
	}
}
