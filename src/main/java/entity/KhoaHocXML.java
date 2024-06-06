
package entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "khoahocs")
@XmlAccessorType(XmlAccessType.FIELD)
public class KhoaHocXML {
    private List<KhoaHoc> khoahoc;

    public List<KhoaHoc> getKhoaHoc() {
        return khoahoc;
    }

    public void setStudent(List<KhoaHoc> khoahoc) {
        this.khoahoc = khoahoc;
    }
}
