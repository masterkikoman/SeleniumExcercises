const { browser, element } = require("protractor");
const { protractor } = require("protractor/built/ptor");

describe('Frames excercises', function() {
    browser.driver.manage().window().maximize();
    browser.waitForAngularEnabled(false);

    it('Open Website', function() {
        
        browser.get('https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm');

    })

    it('Switching to frames', function() {
        var EC = protractor.ExpectedConditions;
        var loc = by.id("iframeResult");
        var el = browser.findElement(loc);

        browser.switchTo().frame(el);
        
        element(by.xpath("//button[text()='Try it']")).click().then(function(){
            browser.sleep(10000);
        });
        
        browser.switchTo().alert().accept();
        element(by.id("demo")).getText().then(function(text){
            console.log(text);
        })
       


         

    })
    



});