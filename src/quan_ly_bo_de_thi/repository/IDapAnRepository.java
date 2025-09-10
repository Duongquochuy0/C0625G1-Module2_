package quan_ly_bo_de_thi.repository;
import quan_ly_bo_de_thi.entity.DapAn;

import java.util.List;

public interface IDapAnRepository {
    List<DapAn> findAll();
    boolean add(DapAn dapAn);
}
