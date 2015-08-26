package files.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ufuk on 26-08-15.
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    void handleFileUpload(@RequestParam("file") MultipartFile file,
                          HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        // Get absolute path of the application
        ServletContext context = request.getServletContext();
        String appPath = context.getRealPath("");
        System.out.println("Virtual Path = " + appPath);

        // Get MIME type of the file
        String fileName = FilenameUtils.getName(file.getName());
        String mimeType = context.getMimeType(fileName);

        if (mimeType == null) {
            // Set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }

        System.out.println("MIME Type: " + mimeType);

        // Set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLengthLong(file.getSize());

        // Set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                file.getOriginalFilename());
        response.setHeader(headerKey, headerValue);

        // Read MultipartFile content
        InputStream is = file.getInputStream();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(is, "UTF-8"));

        String inputLine;

        List<String> lineList = new ArrayList<>();

        while ((inputLine = br.readLine()) != null) {
            lineList.add(inputLine);
        }

        // Sorts the content alphabetically
        Collections.sort(lineList);

        // Because we don't want to keep file on project directory
        File outputFile = File.createTempFile("temp", ".tmp");

        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));

        for (String line : lineList) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        is = new FileInputStream(outputFile);

        // Get output stream of the response
        OutputStream os = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        // Write bytes read from the input stream into the output stream
        while ((bytesRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        // Deletes file when the virtual machine terminate
        outputFile.deleteOnExit();
        os.close();
        is.close();
        br.close();
        bw.close();
    }
}