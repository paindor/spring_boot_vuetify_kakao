<template>
  <div id="app">
    <KakaoLogin
      api-key="<api-key>"
      image="kakao_login_btn_large"
      :on-success=onSuccess
      :on-failure=onFailure
      />
  </div>
</template>
 
<script>
import KakaoLogin from 'vue-kakao-login'
 
let onSuccess = (data) => {
  alert(data)
  alert("success")
}
let onFailure = (data) => {
  alert(data)
  alert("failure")
}
 
export default {
  name: 'App',
  components: {
    KakaoLogin
  },
  methods: {
    onSuccess,
    onFailure
  }
}
</script>
 
<style>
</style>