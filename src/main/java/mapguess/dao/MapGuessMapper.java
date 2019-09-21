package mapguess.dao;

import mapguess.model.MapGuess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MapGuessMapper {
    int insertMapGuess(@Param("mapGuess") MapGuess mapGuess);

    List<Integer> idList();

    MapGuess selectById(int id);

    List<MapGuess> allDataList();

    int deleteById(@Param("id") int id);



}
