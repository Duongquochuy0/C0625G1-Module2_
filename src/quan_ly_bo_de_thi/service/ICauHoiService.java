package quan_ly_bo_de_thi.service;

import quan_ly_bo_de_thi.entity.CauHoi;

import java.util.List;

public interface ICauHoiService {
    List<CauHoi> findAll();
    boolean add(CauHoi cauHoi);
}
