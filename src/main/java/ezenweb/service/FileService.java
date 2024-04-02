package ezenweb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {
    //저장위치
    String path="C:\\Users\\504\\Desktop\\ezen2023B_web2-master\\build\\resources\\main\\static\\image\\";

    //업로드 메소드
    public List<String> fileUpload(List<MultipartFile> multipartFileList){
        //파일저장되는 변수
        List<String> fileList= new ArrayList<>();

        multipartFileList.forEach((multipartFile)->{

            //파일이름 조합 : 새로운 식별이름과실제 파일이름
            String uuid= UUID.randomUUID().toString();
            String fileName=uuid+"_"+multipartFile.getOriginalFilename().replaceAll("_","-");

            //파일 경로 지정
            File file=new File(path+fileName);

            //경로에 기존파일 저장
            try{
                multipartFile.transferTo(file);
            }
            catch (Exception e){
                System.out.println("multipartFileList = " + multipartFileList);
            }

            fileList.add(fileName);
        });

        return fileList;
    }//m end
}//c end
