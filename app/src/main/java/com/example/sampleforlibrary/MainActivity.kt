package com.example.sampleforlibrary

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.blinkbuttonbytechnotoil.Webviewscreen


class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var btnv: Button
    private lateinit var editfield_skus: EditText
    private lateinit var editfield_comp_name: EditText
    private lateinit var editfield_comp_message: EditText
    var mActivity = Webviewscreen()

    var context = this

    var text = "<?php ?>\n" +
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
            "<style>\n" +
            "#iFrameID {\n" +
            "    opacity:1;\n" +
            "\tbackground-color: transparent;\n" +
            "\tposition:absolute;\n" +
            "\twidth:100%;\t\t\t\t\t\t\t\t\n" +
            "\theight:100%;\t\t\t\t\t\t\t\t\t\n" +
            "\ttop:0px;\n" +
            "\tleft:0px;\n" +
            "\tmargin-left: 0%;\n" +
            "  \tmargin-top: 0%;\n" +
            "\tz-index:100;\n" +
            "\tdisplay: none;\n" +
            "\tborder-width: 0px;\n" +
            "}\n" +
            "\n" +
            "#tryonBtnId{\n" +
            "\tbackground-color: black;\n" +
            "\tcolor:white;\n" +
            "\twidth: 100px;\n" +
            "\tcursor: pointer;\n" +
            "}\n" +
            "\n" +
            "</style>\n" +
            "</head>\n" +
            "<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js\"></script>\n" +
            "\n" +
            "<body oncontextmenu=\"return false;\">\n" +
            "\n" +
            "<iframe id=\"iFrameID\" src=\"about:blank\" allow=\"camera\"></iframe>\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "function onTryonClick(allskus, companyName) {\n" +
            "\t\t\n" +
            "\tlet hostURL = window.location;\n" +
            "\tlet tempArr = hostURL.href.split(\"?\");\n" +
            "\n" +
            "\tvar url = \"https://cdn.camweara.com/camweara_jewelry_client/index.php?skus=\" + allskus + \"&company_name=\" + companyName + \"\";\n" +
            "\n" +
            "\tif(tempArr.length > 1){\n" +
            "\t\turl = url + \"?\"+ tempArr[1];\n" +
            "\t}\n" +
            "\tvar iframe = document.getElementById(\"iFrameID\");\n" +
            "\tiframe.style.display = \"block\";\n" +
            "\tiframe.setAttribute(\"src\", url); \n" +
            "}\n" +
            "\n" +
            " window.addEventListener('message', function(event) { \n" +
            "Android.showToast();\n" +

            "    // IMPORTANT: Check the origin of the data! \n" +
            "    if (event.origin.indexOf('https://cdn.camweara.com') || event.origin.indexOf('https://camweara.com')) { \n" +
            "      console.log(\"message: \"+event.data);\n" +
            "      if(event.data == \"closeIframe\"){\n" +
            "        var iframe = document.getElementById(\"iFrameID\");  \n" +
            "        iframe.contentWindow.location.replace(\"\");\n" +
            "        iframe.style.display = \"none\";\n" +
            "      }\n" +
            "      else if(event.data.includes(\"buynow\")){\n" +
            "        console.log(\"buynow message\");\n" +
            "        var iframe = document.getElementById(\"iFrameID\");  \n" +
            "        iframe.contentWindow.location.replace(\"\");\n" +
            "        iframe.style.display = \"none\";\n" +
            "\t\tlet tempArr = event.data.split(\"-\");\n" +
            "\t\tlet sku = tempArr[1];\n" +
            "\t\t//Redirect to Product page or add item to cart using SKU\n" +
            "      \n" +
            "      }\n" +
            "\n" +
            "    } else { \n" +
            "      // The data hasn't been sent from your site! \n" +
            "      // Be careful! Do not use it. \n" +
            "      return; \n" +
            "    } \n" +
            "  }); \n" +
            "\n" +
            "   function load_tryonbutton(skuPassed, camwearaKeyPassed, tryonButtonId){\n" +
            "          productSKU = skuPassed;\n" +
            "\t\t  camwearaKey = camwearaKeyPassed; \n" +
            "\n" +
            "          var today = new Date();\n" +
            "          var dd = String(today.getDate()).padStart(2, '0');\n" +
            "          var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!\n" +
            "          var yyyy = today.getFullYear();\n" +
            "          today = dd + mm + yyyy;\n" +
            "\n" +
            "            let tryon_file_url= \"https://camweara-customers.s3.ap-south-1.amazonaws.com/\" + camwearaKey + \"/\" + camwearaKey + \"_tryonbutton.json?\" + today;\n" +
            "            \n" +
            "          \t  fetch(tryon_file_url)\n" +
            "              .then(function(response){\n" +
            "                  return response.json();\n" +
            "              })\n" +
            "              .then(function(data){\n" +
            "                if(data.sku.includes(productSKU)){\n" +
            "               document.getElementById(tryonButtonId).style.display = 'block';\n" +
            "                }else{\n" +
            "                  document.getElementById(tryonButtonId).style.display = 'none';\n" +
            "                  console.log(productSKU, \"this sku doesn't exist on camweara dashboard\")\n" +
            "                }\n" +
            "                  \n" +
            "              })\n" +
            "        \n" +
            "        }\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "</body>\n" +
            "</html>\n"


    @JavascriptInterface
    fun showToast() {
        //Toast.makeText(this, "Back button", Toast.LENGTH_SHORT).show()
        finish()
    }


    companion object {
        private const val CAMERA_PERMISSION_CODE = 100
        private const val STORAGE_PERMISSION_CODE = 101
    }

    var skus = "demo_1020054,demo_panerai1"
    var companyName = "Teststore"
    var isShow = false;
    var data= false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.buttonView)
        editfield_skus = findViewById(R.id.edit_skus)
        editfield_comp_name = findViewById(R.id.edit_company)
        //editfield_comp_message = findViewById(R.id.edit_message)
        editfield_skus.setText("demo_1020054")
        editfield_comp_name.setText("Teststore")


        mActivity.performWork("Teststore","demo_1020054,hjjgghg"){ result ->
            //use result
            runOnUiThread {

                Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_SHORT)
                    .show()
                if(result==false){
                    btn.isEnabled=false
                    btn.setBackgroundColor(Color.GRAY)
                }
            }


        }

       btn.setOnClickListener {
            if (editfield_skus.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Enter SKU's", Toast.LENGTH_SHORT).show()
            } else if (editfield_comp_name.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Enter company name", Toast.LENGTH_SHORT).show()
            }
//            else if (editfield_comp_message.text.toString().trim().isEmpty()) {
//                Toast.makeText(this, "Enter message name", Toast.LENGTH_SHORT).show()
//            }

            else {
                startActivity(
                    Intent(this, Webviewscreen()::class.java).putExtra(
                        "skus",
                        editfield_skus.text.toString().trim()
                    ).putExtra("companyName", editfield_comp_name.text.toString().trim())

                )
            }
//           var data=  mActivity.myMethod()









        }

        checkPermission(
            android.Manifest.permission.CAMERA,
            CAMERA_PERMISSION_CODE
        )
    }

    private fun checkPermission(permission: String, requestCode: Int) {
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                permission
            ) == PackageManager.PERMISSION_DENIED
        ) {

            // Requesting the permission
            ActivityCompat.requestPermissions(
                this@MainActivity,
                arrayOf(permission),
                requestCode
            )
        } else {
            Toast.makeText(this@MainActivity, "Permission already granted", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this@MainActivity,
                    "Camera Permission Granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Camera Permission Denied",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        } else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this@MainActivity,
                    "Storage Permission Granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Storage Permission Denied",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }
}