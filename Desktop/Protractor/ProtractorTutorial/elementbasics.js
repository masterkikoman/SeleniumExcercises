const{browser, element}=require("protractor");
const { protractor } = require("protractor/built/ptor");
const { Driver } = require("selenium-webdriver/chrome");
describe('Protractor Element demo', function() {
    browser.driver.manage().window().maximize();
    browser.waitForAngularEnabled(false);
   
   
    it('Open Website', function() {
    
        browser.get("http://juliemr.github.io/protractor-demo/");
        element(by.model("first")).sendKeys("12");
        element(by.model("second")).sendKeys("13");
        element(by.css("button[ng-click='doAddition()']")).click();
        browser.sleep(8000);
        //Jasemine assertion expect (it takes care of promise resole)
        expect(element(by.css("h2[class='ng-binding']")).getText()).toBe("25");
        element(by.css("h2[class='ng-binding']")).getText().then(function(text) {
            console.log(text);
        });

    });


    it('Close Website', function() {

    })


});