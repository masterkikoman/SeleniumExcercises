exports.config = {

    seleniumAddress: 'http://localhost:4444/wd/hub',

    framework:'jasmine',

    specs: ['frames.js'],
    

    jasmineNodeOpts: {
      defaultTimeoutInterval: 60000
    },

    //Adding browser capabilities
    capabilities: {
        'goog:chromeOptions': {
          w3c:false
        },
      'browserName':'chrome'
    }

     
  
  };