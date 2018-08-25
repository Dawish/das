package d.as.dao;

import java.util.List;

import d.as.bean.Dic;

public interface DicDao {
    List<Dic> select(Dic dic);
}