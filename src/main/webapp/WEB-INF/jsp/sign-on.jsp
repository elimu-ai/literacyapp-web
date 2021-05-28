<content:title>
    <fmt:message key="sign.on" />
</content:title>

<content:section cssId="signOnPage">
    <h2 class="center"><i class="material-icons large deep-purple-text">group</i></h2>
    <h2 class="center"><fmt:message key="join.the.community" /></h2>
    
    <div class="section">
        <div class="row section">
            <p class="center"><fmt:message key="sign.on.via.an.existing.account" />:</p>
            
            <div class="col s12 m4 offset-m4">
                <a href="<spring:url value='/sign-on/google' />" class="col s12 btn-large waves-effect waves-light white grey-text">
                    <svg style="width: 24px; height: 24px; top: 6px; position: relative; right: 5px;" viewBox="0 0 533.5 544.3" xmlns="http://www.w3.org/2000/svg"><path d="M533.5 278.4c0-18.5-1.5-37.1-4.7-55.3H272.1v104.8h147c-6.1 33.8-25.7 63.7-54.4 82.7v68h87.7c51.5-47.4 81.1-117.4 81.1-200.2z" fill="#4285f4"/><path d="M272.1 544.3c73.4 0 135.3-24.1 180.4-65.7l-87.7-68c-24.4 16.6-55.9 26-92.6 26-71 0-131.2-47.9-152.8-112.3H28.9v70.1c46.2 91.9 140.3 149.9 243.2 149.9z" fill="#34a853"/><path d="M119.3 324.3c-11.4-33.8-11.4-70.4 0-104.2V150H28.9c-38.6 76.9-38.6 167.5 0 244.4l90.4-70.1z" fill="#fbbc04"/><path d="M272.1 107.7c38.8-.6 76.3 14 104.4 40.8l77.7-77.7C405 24.6 339.7-.8 272.1 0 169.2 0 75.1 58 28.9 150l90.4 70.1c21.5-64.5 81.8-112.4 152.8-112.4z" fill="#ea4335"/></svg>
                    &nbsp;Sign in with Google
                </a>
            </div>
        </div>
        
        <div class="divider"></div>
                
        <div class="row section">
            <p class="center"><fmt:message key="are.you.a.developer" /></p>
            
            <div class="col s12 m4 offset-m4">
                <a href="<spring:url value='/sign-on/github' />" class="col s12 btn-large waves-effect waves-light grey darken-1">
                    <svg style="width: 32px; height: 32px; top: 6px; position: relative; right: 5px;" viewBox="0 0 50 50">
                        <path fill="#ffffff" d="M32,16c-8.8,0-16,7.2-16,16c0,7.1,4.6,13.1,10.9,15.2 c0.8,0.1,1.1-0.3,1.1-0.8c0-0.4,0-1.4,0-2.7c-4.5,1-5.4-2.1-5.4-2.1c-0.7-1.8-1.8-2.3-1.8-2.3c-1.5-1,0.1-1,0.1-1 c1.6,0.1,2.5,1.6,2.5,1.6c1.4,2.4,3.7,1.7,4.7,1.3c0.1-1,0.6-1.7,1-2.1c-3.6-0.4-7.3-1.8-7.3-7.9c0-1.7,0.6-3.2,1.6-4.3 c-0.2-0.4-0.7-2,0.2-4.2c0,0,1.3-0.4,4.4,1.6c1.3-0.4,2.6-0.5,4-0.5c1.4,0,2.7,0.2,4,0.5c3.1-2.1,4.4-1.6,4.4-1.6 c0.9,2.2,0.3,3.8,0.2,4.2c1,1.1,1.6,2.5,1.6,4.3c0,6.1-3.7,7.5-7.3,7.9c0.6,0.5,1.1,1.5,1.1,3c0,2.1,0,3.9,0,4.4 c0,0.4,0.3,0.9,1.1,0.8C43.4,45.1,48,39.1,48,32C48,23.2,40.8,16,32,16z" />
                    </svg>
                    &nbsp;Sign in with GitHub
                </a>
            </div>
        </div>

        <div class="divider"></div>
                
        <div class="row section">
            <p class="center"><fmt:message key="are.you.a.developer" /></p>
            
            <div class="col s12 m4 offset-m4" id="web3">
                <p  class="col s12 btn-large waves-effect waves-light grey darken-1">
                    
                    &nbsp;Sign in with Web3 wallet
                </p>
            </div>
        </div>
        <form id="web3-form" action="<spring:url value='/sign-on/web3' />" method="post">
            <input type="hidden" name="address" id="web3-address" />
            <input type="hidden" name="signature" id="web3-signature"  />
        </form>
    </div>    
</content:section>
