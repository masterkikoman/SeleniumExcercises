const{browser, element}=require("protractor");
const { protractor } = require("protractor/built/ptor");
const { Driver } = require("selenium-webdriver/chrome");

describe('Drop Down Locator List', function() {
    browser.driver.manage().window().maximize();

    function Calc(a,b,c) {
        element(by.model("first")).sendKeys(a);
        element(by.model("second")).sendKeys(b); 
        //Having all in locator and each finds all the element needed in the parent
        element.all(by.tagName("option")).each(function(item) {
            item.getAttribute("value").then(function(values) {
                
                if(values==c) {
                    item.click();
                }
               
            })
        })

        element(by.id("gobutton")).click();  
    }


    it('All Locators sample', function() {
        browser.get("http://juliemr.github.io/protractor-demo/");
        Calc(2,3,"MULTIPLICATION");
        Calc(5,6,"ADDITION");
        Calc(7,8,"SUBTRACTION");
        Calc(9,4,"MODULO");
        Calc(0,1,"DIVISION");
        browser.sleep(8000);

        element.all(by.repeater("result in memory")).each(function(item) {
            item.element(by.css("td:nth-child(3)")).getText().then(function(text) {

                console.log(text);
            })
        }) 
        
    }) 

})


