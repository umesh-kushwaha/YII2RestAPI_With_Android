<?php

namespace app\controllers;
use Yii;
use yii\web\Controller;
use yii\web\Response;
use app\models\Users;
use app\common\Constant;
class UsersController extends Controller
{
    public $enableCsrfValidation = false;
    
    public function behaviors()
    {
        Yii::$app->response->format = Response:: FORMAT_JSON;
        return [
            'verbs' => [
                'class' => \yii\filters\VerbFilter::className(),
                'actions' => [
                    'index' => ['GET', 'HEAD'],
                     'login' => ['POST'],
                     'create-user' => ['POST'],
                    'update' => ['PUT', 'PATCH'],
                    'delete' => ['DELETE'],
                ],
            ],
        ];
    }
    
    
    public function actionIndex()
    {
        echo 'testing';        exit();
        return $this->render('index');
    }

    public function actionCreateUser(){
        $user = new Users();
        $user->scenario = Users::SCENARIO_CREATE;
        $user->attributes = Yii::$app->request->post();
        $user->secret_key = Yii::$app->getSecurity()->generatePasswordHash($user->getCurrentTimeInMili());

       if($user->validate()){
            $user->password = Yii::$app->getSecurity()->generatePasswordHash($user->password);
            $user->registered_date = $user->getCurrentTimeInMili();
            $user->last_logged_in = $user->getCurrentTimeInMili();
            $user->is_active     = 1;
            $user->save();
            
            $user->secret_key = '';
            $user->password = '';
            return array(Constant::STATUS_CODE=>'200', Constant::STATUS => TRUE,
                Constant::MESSAGE=> 'User record is successfully ADDED', 
                Constant::USER=>$user);
       }else{
           $errors = $user->getErrors();
           $message='';
           foreach ($errors as $value) {
               $message = $message.$value[0];
           }
         
           return array(Constant::STATUS_CODE=>'200', Constant::STATUS => FALSE,
                Constant::MESSAGE=> $message, Constant::USER=>''); 
       }
    }
    
    public function actionLogin(){
        $user = new Users();
        $user->scenario = Users::SCENARIO_LOGIN;
        $user->attributes = Yii::$app->request->post();
        
       if($user->validate() && $user->hasUser($user->username, $user->password)){
           $user = $user->getUserByName($user->username);
           $user->last_logged_in = $user->getCurrentTimeInMili();
           $user->save();
           $user->secret_key = '';
           $user->password = '';
           return array(Constant::STATUS_CODE=>'200', Constant::STATUS => TRUE,
                Constant::MESSAGE=> 'Logedin successfully', Constant::USER=>$user);
           
       }else{
           return array(Constant::STATUS_CODE=>'200', Constant::STATUS => FALSE,
                Constant::MESSAGE=> 'User name or password is wrong.', Constant::USER=>'');
       }
    }
    
    public function actionUpdate(){
        
    }
    
    public function actionDelete(){
        
    }
}
