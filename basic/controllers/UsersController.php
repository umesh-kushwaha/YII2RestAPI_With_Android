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
        $user->attributes = \yii::$app->request->post();
        $user->password = Yii::$app->getSecurity()->generatePasswordHash($user->password);

       if($user->validate()){
            $user->save();
            return array(Constant::STATUS_CODE=>'200', Constant::STATUS => TRUE,
                Constant::MESSAGE=> 'User record is successfully ADDED', Constant::DATA=>'');
       }else{
           return array(Constant::STATUS_CODE=>'200', Constant::STATUS => FALSE,
                Constant::MESSAGE=> $user->getErrors(), Constant::DATA=>'');
       }
    }
    
    public function actionLogin(){
        $user = new Users();
        $user->scenario = Users::SCENARIO_LOGIN;
        $user->attributes = \yii::$app->request->post();

       if($user->validate() && $user->hasUser($user->username, $user->password)){
           return array(Constant::STATUS_CODE=>'200', Constant::STATUS => TRUE,
                Constant::MESSAGE=> 'Logedin successfully', Constant::DATA=>'');
           
       }else{
           return array(Constant::STATUS_CODE=>'200', Constant::STATUS => FALSE,
                Constant::MESSAGE=> 'User name or password is wrong.', Constant::DATA=>'');
       }
    }
    
    public function actionUpdate(){
        
    }
    
    public function actionDelete(){
        
    }
}
