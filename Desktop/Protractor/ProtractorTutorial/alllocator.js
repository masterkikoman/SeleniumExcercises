const{browser, element}=require("protractor");
const { protractor } = require("protractor/built/ptor");
const { Driver } = require("selenium-webdriver/chrome");

describe('All Locators demo', function() {
    browser.driver.manage().window().maximize();

    function Add(a,b) {
        element(by.model("first")).sendKeys(a);
        element(by.model("second")).sendKeys(b); 

        element(by.id("gobutton")).click();  
    }



    it('All Locators sample', function() {
        browser.get("http://juliemr.github.io/protractor-demo/");
        Add(2,3);
        Add(5,6);
        Add(7,8);
        Add(9,4);
        Add(0,1);
        browser.sleep(8000);
        
        //Having all in locator and each finds all the element needed in the parent
        element.all(by.repeater("result in memory")).each(function(item) {
            item.element(by.css("td:nth-child(3)")).getText().then(function(text) {

                console.log(text);
            })
        }) 

    })


});