package mapguess.controllers;


import mapguess.dao.MapGuessMapper;
import mapguess.model.MapGuess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MapGuessController {

    @Autowired
    private MapGuessMapper mapGuessMapper;


    @ResponseBody
    @RequestMapping(value="/mapguesstest")
    public void insertMapGuess(@RequestBody MapGuess mapGuess){
        try {
            mapGuessMapper.insertMapGuess(mapGuess);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @ResponseBody
    @RequestMapping(value="/mapguess")
    public MapGuess queryXYvalue(){
//        //1.先拿到数据库中所有的id；
//          2.以这个id为基础，产生随意数a ;
//          3.基于随机数，在数据库中拿到图片的X值Y值；
        try{
            List<Integer> idList=mapGuessMapper.idList();
            int radomIndex = new Random().nextInt(idList.size());
            Integer id = idList.get(radomIndex);
            return mapGuessMapper.selectById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }


    @ResponseBody
    @RequestMapping(value="/queryAll")
    public List<MapGuess> getAllData(){

        try{
            List<MapGuess> mapGuessList= new ArrayList<>();
            return mapGuessMapper.allDataList();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @RequestMapping(value="/deleteId" )
    public void deleteMapGuess(@RequestParam("id") int id){
        try {
            mapGuessMapper.deleteById(id);

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
