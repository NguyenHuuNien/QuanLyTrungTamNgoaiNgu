package utils;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileUtils {

    /**
     * Chuyển đổi đối tượng object về định dạng XML
     * Sau đo lưu vào fileName
     * 
     * @param fileName
     * @param object
     */
    public static void writeXMLtoFile(String fileName, Object object) {
        try {
            File xmlFile = new File("data/" + fileName);
            // tạo đối tượng JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            // Create đối tượng Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // formating 
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // lưu nội dung XML vào file
            jaxbMarshaller.marshal(object, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    /**
     * Đọc nội dung fileName, sau đó chuyển đổi nội dung của file 
     * thành đối tượng có kiểu là clazz.
     * 
     * @param fileName
     * @param clazz
     * @return
     */
    public static Object readXMLFile(String fileName, Class<?> clazz) {
        try {
            File xmlFile = new File("data/" + fileName);
            System.out.println("Đường dẫn tuyệt đối: " + xmlFile.getAbsolutePath());
            if (!xmlFile.exists()) {
                throw new FileNotFoundException("File not found: " + fileName);
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
