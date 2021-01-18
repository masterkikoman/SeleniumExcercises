const { browser, element } = require("protractor");

describe('Child Windows Samples', function() {
    browser.driver.manage().window().maximize();
    browser.waitForAngularEnabled(false);

    it('Open Website', function() {
        //Write real protractor code
        browser.get('https://www.cambridge.org');
        browser.sleep(5000);
            
    })
    
    it('Clicking for new window', function(){
        browser.actions().mouseDown(element(by.css("a[href*='authorhub']"))).click().perform().then(function(){
            browser.sleep(5000);
        });
        
        browser.getAllWindowHandles().then(function(handles){
            browser.getTitle().then(function(title){
                console.log(title);
            })
            
            browser.switchTo().window(handles[1]);            
            browser.getTitle().then(function(title){
                console.log(title);
            })

            browser.switchTo().window(handles[0]);
            browser.getTitle().then(function(title){
                console.log(title);
            })
            
        })
    })


});