package quan_ly_bo_de_thi.service;

import quan_ly_bo_de_thi.entity.CauHoi;
import quan_ly_bo_de_thi.entity.DapAn;
import quan_ly_bo_de_thi.repository.CauHoiRepository;
import quan_ly_bo_de_thi.repository.DapAnRepository;
import quan_ly_bo_de_thi.repository.ICauHoiRepository;
import quan_ly_bo_de_thi.repository.IDapAnRepository;

import java.util.List;

public class CauHoiService implements ICauHoiService {
    private ICauHoiRepository cauHoiRepository = new CauHoiRepository();
    private IDapAnRepository dapAnRepository = new DapAnRepository();

    @Override
    public List<CauHoi> findAll() {
        List<CauHoi> cauHoiList = cauHoiRepository.findAll();
        List<DapAn> dapAnList = dapAnRepository.findAll();
        for (CauHoi cauHoi : cauHoiList) {
            for (DapAn dapAn : dapAnList) {
                if (dapAn.getMaCauHoi().equals(cauHoi.getMaCauHoi())) {
                    cauHoi.themDapAn(dapAn);
                }
            }
        }
        return cauHoiList;
    }

    @Override
    public boolean add(CauHoi cauHoi) {
        boolean flag = cauHoiRepository.add(cauHoi);
        if (!flag) return false;
        for (DapAn dapAn : cauHoi.getDapAns()) {
            boolean added = dapAnRepository.add(dapAn);
            if (!added) {
                System.out.println("Lỗi ghi đáp án " + dapAn.getMaDapAn());
                return false;
            }
        }
        return true;
    }
}
