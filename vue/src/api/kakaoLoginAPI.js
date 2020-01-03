import axios from 'axios'
export default{
	async login (data) {
    alert(`테스트 ${self} ,  ${data.userid},${data.passwd}` )
            
            let url = `https://developers.kakao.com/sdk/js/kakao.min.js`
            alert('>>>>>>'+url)
            let headers = {
                'authorization': 'JWT fefege..',
                'Accept' : 'application/json',
                'Content-Type': 'application/json'
            }
            axios
            .post(url, data, headers)
            .then(res=>{
                if(res.data.result === "SUCCESS"){
                  alert(`로그인 2020 성공`)
                  
                  
                }else{
                  alert(`로그인실패`)
                  this.$router.push({path: '/login'})
                }
            })
            .catch(()=>{
                alert('AXIOS 실패')
            })  
  }
}