package quan_ly_bo_de_thi.repository;

import quan_ly_bo_de_thi.entity.CauHoi;
import java.util.List;

public interface ICauHoiRepository {
    List<CauHoi> findAll();
    boolean add(CauHoi cauHoi);
}
