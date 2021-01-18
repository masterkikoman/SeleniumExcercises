const { browser, element } = require("protractor");
const { protractor } = require("protractor/built/ptor");

describe('Actions for Auto suggestive drop down', function() {
    browser.driver.manage().window().maximize();

    it('Open Browser', function(){
        browser.waitForAngularEnabled(false);
        browser.get('https://weather.com');
        
    })

    it('Actions class', function() {
        browser.sleep(5000);
        browser.actions().mouseMove(element(by.id("LocationSearch_input")))
        .click()
        .sendKeys("Tokyo").
        perform().then(function(){
            browser.sleep(5000);
        });
        browser.actions().sendKeys(protractor.Key.ARROW_DOWN).perform();
        browser.actions().sendKeys(protractor.Key.ENTER).perform().then(function(){
            browser.sleep(5000);
            //check if buttons are present and correct count is return on a page
            expect(element.all(by.css("a[class*='Button--primary']")).count()).toEqual(5).then(function(){
                //browser.sleep(5000);

                //browser.actions().mouseDown(element.all(by.css("a[class*='Button--primary']"))).get(1).click().perform();
                element.all(by.css("a[data-testid*='ctaButton']")).each(function(item){
                    //browser.actions().mouseDown(item).get(1).click().perform();
                    item.getText().then(function(text){
                        //console.log(text);
                        if(text=="Next 48 Hours"){

                            browser.actions().mouseDown(item).perform();
                            browser.sleep(5000);
                            item.click();
                            browser.sleep(5000);
                        }
                    })
                })

            });
           
        });
     
    })
    
});