<template>
<div class="signup-form">
  <form >
        <h2>Register</h2>
        <p class="hint-text">Create your account. It's free and only takes a minute.</p>
    <div class="form-group">
            <div class="row">
                <div class="col-xs-6"><input v-model="userid" type="text" class="form-control" placeholder="아이디" required="required"></div>
                <div class="col-xs-6"><input v-model="passwd" type="password" class="form-control" placeholder="비밀번호" required="required"></div>
            </div>            
    </div>
    <div class="form-group">
      <input v-model="name" type="text" class="form-control" placeholder="이름" required="required">
    </div>
        <div class="form-group">
      <input v-model="birthday" type="text" class="form-control" placeholder="생일 ex ) 1999-12-31" required="required">
    </div>
        <div class="form-group">
      <div @click.prevent="join" class="btn btn-success btn-lg btn-block">Register Now</div>
    </div>
  </form>
  <div class="text-center">Already have an account? <a href="#">Sign in</a></div>
</div>
</template>
<script>

export default{
    name: 'join',
   
}
</script>
<style scoped>
body{
    color: #fff;
    background: #63738a;
    font-family: 'Roboto', sans-serif;
}
  .form-control{
    height: 40px;
    box-shadow: none;
    color: #969fa4;
}
.form-control:focus{
    border-color: #5cb85c;
}
.form-control, .btn{        
  border-radius: 3px;
}
.signup-form{
    width: 400px;
    margin: 0 auto;
    padding: 30px 0;
}
.signup-form h2{
    color: #636363;
  margin: 0 0 15px;
    position: relative;
    text-align: center;
}
.signup-form h2:before, .signup-form h2:after{
    content: "";
    height: 2px;
    width: 30%;
    background: #d4d4d4;
    position: absolute;
    top: 50%;
    z-index: 2;
}   
.signup-form h2:before{
    left: 0;
}
.signup-form h2:after{
    right: 0;
}
.signup-form .hint-text{
    color: #999;
    margin-bottom: 30px;
    text-align: center;
}
.signup-form form{
    color: #999;
    border-radius: 3px;
  margin-bottom: 15px;
  background: #f2f3f7;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  padding: 30px;
}
.signup-form .form-group{
  margin-bottom: 20px;
}
.signup-form input[type="checkbox"]{
    margin-top: 3px;
}
.signup-form .btn{        
  font-size: 16px;
  font-weight: bold;        
    min-width: 140px;
  outline: none !important;
}
.signup-form .row div:first-child{
    padding-right: 10px;
}
.signup-form .row div:last-child{
    padding-left: 10px;
}       
.signup-form a{
    color: #fff;
    text-decoration: underline;
}
.signup-form a:hover{
    text-decoration: none;
}
.signup-form form a{
    color: #5cb85c;
    text-decoration: none;
}   
.signup-form form a:hover{
    text-decoration: underline;
}  
</style>