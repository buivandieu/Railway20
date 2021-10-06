DROP DATABASE IF EXISTS SQL_LESSON_3;
CREATE DATABASE		SQL_LESSON_3;
USE								SQL_LESSON_3;

-- Tạo bảng Department
CREATE TABLE IF NOT EXISTS Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  DepartmentName 		NVARCHAR(30) NOT NULL UNIQUE KEY
);

-- Tạo bảng Posittion
CREATE TABLE IF NOT EXISTS `Position` (
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);

--  Tạo bảng: Account
CREATE TABLE IF NOT EXISTS `Account` (
		AccountID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email						VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				NVARCHAR(50) NOT NULL,
    DepartmentID 		TINYINT UNSIGNED NOT NULL,
    PositionID			TINYINT UNSIGNED NOT NULL,
    CreateDate			DATETIME,
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID)   REFERENCES `Position`(PositionID)
);

--  Tạo bảng: Group
CREATE TABLE IF NOT EXISTS `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorID				INT UNSIGNED,
    CreateDate				DATETIME,
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId)
);

--  Tạo bảng GroupAccount
CREATE TABLE IF NOT EXISTS `GroupAccount`(
		GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID			INT UNSIGNED NOT NULL,
    JoinDate			DATETIME,
    FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID) 
);

-- c Tạo bảng TypeQuestion
CREATE TABLE IF NOT EXISTS TypeQuestion (
    TypeID 			INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName 		ENUM('Essay','Multiple-Choice')
);

--  Tạo bảng CategoryQuestion
CREATE TABLE IF NOT EXISTS CategoryQuestion(
    CategoryID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY
);

--  Tạo bảng Question
CREATE TABLE IF NOT EXISTS Question(
    QuestionID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    CategoryID				INT UNSIGNED NOT NULL,
    TypeID					INT UNSIGNED NOT NULL,
    CreatorID				INT UNSIGNED NOT NULL,
    CreateDate				DATETIME,
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId) 
);

--  Tạo bảng Answer
CREATE TABLE IF NOT EXISTS Answer(
    AnswerID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(100) NOT NULL,
    QuestionID				INT UNSIGNED NOT NULL,
    isCorrect				Boolean,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);

--  Tạo bảng Exam
CREATE TABLE IF NOT EXISTS Exam(
    ExamID					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY  ,
    `Code`					VARCHAR(10),
    Title					NVARCHAR(50) ,
    CategoryID				INT UNSIGNED ,
    Duration				INT UNSIGNED,
    CreatorID				INT UNSIGNED,
    CreateDate				DATETIME,
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId)
);

--  Tạo bảng ExamQuestion
CREATE TABLE IF NOT EXISTS ExamQuestion(
    ExamID				INT UNSIGNED ,
	QuestionID			INT UNSIGNED,
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID),
    FOREIGN KEY(ExamID)     REFERENCES Exam(ExamID)
);

-- ----------------NHẬP DỮ LIỆU DATABASE-----------------------------------------

-- ---Nhập dữ liệu bảng Department
INSERT INTO Department(DepartmentName) 
VALUES
						('Marketing'	),
						('Sale'		    ),
						('Bảo vệ'		),
						('Nhân sự'		),
						('Kỹ thuật' 	),
						('Tài chính'	),
						('Phó giám đốc' ),
						('Giám đốc' 	),
						('Thư kí'		),
						('Bán hàng' 	);
                        
-- ---Nhập dữ liệu bảng Position
INSERT INTO `Position`	(PositionName	) 
VALUES 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			);                     

-- ---Nhập dữ liệu bảng  Account
INSERT INTO  `Account` (Email                       ,Username   ,FullName         ,DepartmentID,PositionID,CreateDate  )
VALUES                 ('NguyenVanAn@gmail.com'      ,'Anpro'   ,'Doan Văn O'  ,        1   ,    3     ,'2020-01-01'),
                       ('NguyenVanTri@gmail.com'     ,'Tripro'  ,'Nguyễn Văn Trí' ,        3   ,    1     ,'2021-04-11'),
                       ('NguyenVanHan@gmail.com'     ,'Hanpro'  ,'Nguyễn Văn Hàn' ,        3   ,    2     ,'2017-08-21'),
                       ('NguyenVanHung@gmail.com'    ,'Hung'    ,'Nguyễn Văn Hùng',        7   ,    4     ,'2021-04-01'),
                       ('NguyenVanHuy@gmail.com'     ,'Huypro'  ,'Nguyễn Văn Huy' ,        9   ,    3     ,'2019-05-30'),
                       ('NguyenVanHau@gmail.com'     ,'Haupro'  ,'Nguyễn Văn Hậu' ,        2   ,    1     ,'2021-07-25'),
                       ('NguyenVanBi@gmail.com'      ,'Bipro'   ,'Nguyễn Văn Bi'  ,        4   ,    2     ,'2020-10-11'),
                       ('NguyenVanKhai@gmail.com'    ,'Khaipro' ,'Nguyễn Văn Khai',        6   ,    1    ,'2019-11-25'),
                       ('NguyenVanHuan@gmail.com'    ,'Huanpro' ,'Nguyễn Văn Huấn',        3   ,    4     ,'2018-10-10'),
                       ('NguyenVanTung@gmail.com'    ,'Tungpro' ,'Nguyễn Văn Tùng',        10  ,    2     ,'2021-05-01');

-- ---Nhập dữ liệu bảng Group            
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUES 				('AFC10'               	,   4			,'2018-01-02'),
					('AFC11'		        ,   2			,'2021-05-14'),
                    ('AFC5'			        ,   5			,'2019-09-16'),
                    ('AFC3'			        ,   5			,'2020-08-25'),
                    ('AFC4'			        ,   7			,'2021-04-30'),
                    ('AFC16'		    	,   10			,'2017-04-15'),
                    ('AFC166'	            ,   1			,'2021-10-11'),
                    ('AFC177'		        ,   7			,'2020-09-17'),
                    ('AFC21'		        ,   2			,'2019-05-04'),
                    ('AFC101'	        	,   4			,'2018-04-10');  
                    
 -- ---Nhập dữ liệu bảng GroupAccount
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    6		,'2019-03-05'),
							(	2		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	4		,    4		,'2020-03-10'),
							(	5		,    9		,'2020-03-28'),
							(	6		,    3		,'2020-04-06'),
							(	7		,    6		,'2020-04-07'),
							(	8		,    5		,'2020-04-08'),
							(	9		,    10		,'2020-04-09'),
							(	10		,    3		,'2020-04-10');

-- ---Nhập dữ liệu bảng TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 
 
-- ---Nhập dữ liệu bảng CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUES 								('Java'			),
									('NET'	    	),
									('Postman1'		),
									('SQ1L'			),
									('Postman'		),
									('Ruby'			),
									('Java1'		),
									('C++'			),
									('SQL'		    ),
									('NET1'			);

-- ---Nhập dữ liệu bảng Question 
INSERT INTO Question	(Content			    , CategoryID, TypeID		, CreatorID	, CreateDate )
VALUES 					('Câu hỏi về Java '	    ,	1		, 	    2 	    ,        3	,'2021-01-02'),
						('Câu Hỏi về NET'	    ,	3		,       1       ,   	 4	,'2019-07-06'),
						('Câu hỏi về SQL'	    ,	7		,  	    1       ,   	 5  ,'2018-11-17'),
						('Câu hỏi về Ruby'	    ,	4		,   	1    	,   	1	,'2021-12-25'),
						('Câu hỏi về Java'      ,	10		,   	2		,   	10  ,'2021-03-24'),
						('Câu hỏi về Postman'   ,	4		,   	2		,   	4   ,'2019-07-30'),
						('Câu hỏi về Java'      ,	2		,   	2		,   	6	,'2020-10-25'),
						('Câu hỏi về Ruby'	    ,	4		,   	1		,   	10	,'2021-12-15'),
						('Câu hỏi về SQL'	    ,	9		,  		2   	,   	1   ,'2021-11-03'),
						('Câu hỏi về NET'       ,	7		,   	2		,   	3   ,'2021-05-11');
                        
-- ---Nhập dữ liệu bảng Answer 
INSERT INTO Answer	(  Content		                , QuestionID	, isCorrect	)
VALUES 				('Nội dung của câu trả lời A'	,   2			,	1		),
					('Nội dung của câu trả lời A'	,   10			,	1		),
                    ('Nội dung của câu trả lời O'	,   7			,	0		),
                    ('Nội dung của câu trả lời A'	,   2   		,	0		),
                    ('Nội dung của câu trả lời L'	,   5			,	1		),
                    ('Nội dung của câu trả lời D'	,   2			,	1		),
                    ('Nội dung của câu trả lời G'	,   7			,	0		),
                    ('Nội dung của câu trả lời F'	,   9			,	0		),
                    ('Nội dung của câu trả lời D'	,   2			,	1		),
                    ('Nội dung của câu trả lời A'	,   9			,	0		);
                    
-- ---Nhập dữ liệu bảng Exam 
INSERT INTO Exam	(`Code`			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUES 				('RAILWAY1'	    	, 'Đề thi số 01'	    ,	5			,	90		,   '1'			,'2021-01-20'),
					('RAILWAY2'		, 'Đề thi số 03'		,	2			,	60		,   '3'			,'2019-02-22'),
                    ('RAILWAY3'		, 'Đề thi số 05'		,	1			,	120		,   '4'			,'2021-07-26'),
                    ('RAILWAY4'		, 'Đề thi số 07'		,	4			,	60		,   '7'			,'2020-03-27'),
                    ('RAILWAY5'		, 'Đề thi số 12'		,	10			,	120		,   '9'			,'2019-08-30'),
                    ('RAILWAY6'		, 'Đề thi số 21'		,	3			,	60		,   '10'		,'2021-04-19'),
                    ('RAILWAY7'	    , 'Đề thi số 04'		,	5			,	45		,   '8'			,'2021-09-26'),
                    ('RAILWAY8'		, 'Đề thi số 08'		,	9			,	60		,   '10'		,'2019-07-25'),
                    ('RAILWAY9'		, 'Đề thi số 09'		,	8			,	120		,   '2'			,'2021-09-15'),
                    ('RAILWAY10'	, 'Đề thi số 11'		,	2			,	90		,   '7'		    ,'2021-01-11');
 
-- ---Nhập dữ liệu bảng ExamQuestion
INSERT INTO ExamQuestion(ExamID	, QuestionID	) 
VALUES 					(	1	,		2		),
						(	2	,		6		), 
						(	3	,		10		), 
						(	4	,		4		), 
						(	5	,		2		), 
						(	6	,		1		), 
						(	7	,		6		), 
						(	8	,		10		), 
						(	9	,		1		), 
						(	10	,		6		);
				
		
SELECT*
                        
                        
                        
                        