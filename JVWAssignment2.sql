GO
/****** Object:  Database [JVWAssignment2]    Script Date: 04/14/2016 18:56:34 ******/
CREATE DATABASE [JVWAssignment2] 
USE [JVWAssignment2]
GO
/****** Object:  Table [dbo].[tbl_status]    Script Date: 04/14/2016 18:56:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_status](
	[statusID] [int] NOT NULL,
	[name] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_status] PRIMARY KEY CLUSTERED 
(
	[statusID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_status] ([statusID], [name]) VALUES (0, N'Rejected')
INSERT [dbo].[tbl_status] ([statusID], [name]) VALUES (1, N'Pending')
INSERT [dbo].[tbl_status] ([statusID], [name]) VALUES (2, N'Accepted')
/****** Object:  Table [dbo].[tbl_roles]    Script Date: 04/14/2016 18:56:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_roles](
	[role] [int] NOT NULL,
	[description] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_roles] PRIMARY KEY CLUSTERED 
(
	[role] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_roles] ([role], [description]) VALUES (0, N'Employee')
INSERT [dbo].[tbl_roles] ([role], [description]) VALUES (1, N'Manager')
/****** Object:  Table [dbo].[tbl_department]    Script Date: 04/14/2016 18:56:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_department](
	[depID] [nvarchar](20) NOT NULL,
	[name] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_department] PRIMARY KEY CLUSTERED 
(
	[depID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_department] ([depID], [name]) VALUES (N'P01', N'Business Department')
INSERT [dbo].[tbl_department] ([depID], [name]) VALUES (N'P02', N'Finacial Department')
INSERT [dbo].[tbl_department] ([depID], [name]) VALUES (N'P03', N'Human Resource')
/****** Object:  Table [dbo].[tbl_employee]    Script Date: 04/14/2016 18:56:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_employee](
	[employeeID] [nvarchar](20) NOT NULL,
	[name] [nvarchar](20) NOT NULL,
	[address] [nvarchar](20) NOT NULL,
	[email] [nvarchar](30) NOT NULL,
	[phone] [varchar](11) NOT NULL,
	[manager] [bit] NOT NULL,
	[depID] [nvarchar](20) NOT NULL,
	[status] [int] NOT NULL,
	[salary] [float] NOT NULL,
	[family] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_employee] PRIMARY KEY CLUSTERED 
(
	[employeeID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'002', N'gfd', N'gfd', N'gfd', N'43', 0, N'P03', 0, 43, N'gfd')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E001', N'Tu', N'rggdf', N'dvgd', N'45435345', 1, N'P01', 0, 50000000, N'FAA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E002', N'Tan', N'CMT8', N'tan.nguyen', N'1234567', 0, N'P01', 1, 3432, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E003', N'Tung', N'gfd', N'gfd', N'1223465798', 0, N'P01', 1, 342432.4375, N'FA453')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E004', N'Truong', N'gfdas', N'gfd', N'69696969', 0, N'P01', 0, 696969, N'FA564412')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E005', N'Nghia', N'rew', N'gf', N'12345678907', 0, N'P01', 0, 444444, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E006', N'Thanh', N'rew', N'gfd', N'0999999999', 1, N'P02', 0, 6868686868, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E007', N'Huy', N'rew', N'gfd', N'0808080808', 0, N'P02', 2, 7777778, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E008', N'Tuan', N'rew', N'gfd', N'2431231455', 0, N'P02', 2, 34343434, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E009', N'Tu', N'rew', N'gfd', N'3522377582', 0, N'P02', 0, 666666666, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E010', N'Tung', N'rew', N'gfd', N'2342214455', 0, N'P02', 0, 67474635, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E011', N'Quang', N'rew', N'gfd', N'0968686868', 1, N'P03', 1, 999999999, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E012', N'Hieu', N'rew', N'gfd', N'2347178588', 0, N'P03', 0, 4434431, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E013', N'HPuong', N'rew', N'gfd', N'0993412311', 0, N'P03', 0, 3267676, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E014', N'Ha', N'rew', N'gfd', N'0903696969', 0, N'P03', 2, 7874593, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'E015', N'Hung', N'rw', N'gfd', N'0987987987', 0, N'P03', 0, 56576545, N'FA')
INSERT [dbo].[tbl_employee] ([employeeID], [name], [address], [email], [phone], [manager], [depID], [status], [salary], [family]) VALUES (N'quang', N'fdgfgdg', N'fgf', N'gddf', N'453543', 0, N'P03', 2, 4534, N'gdgfd')
/****** Object:  Table [dbo].[tbl_leave]    Script Date: 04/14/2016 18:56:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_leave](
	[leaveID] [int] IDENTITY(1,1) NOT NULL,
	[fromDate] [datetime] NOT NULL,
	[toDate] [datetime] NOT NULL,
	[accept] [bit] NOT NULL,
	[empID] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tbl_leave] PRIMARY KEY CLUSTERED 
(
	[leaveID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tbl_leave] ON
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (1, CAST(0x0000A5DE00000000 AS DateTime), CAST(0x0000A5DE00C5C100 AS DateTime), 0, N'E011')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (2, CAST(0x0000A5F100000000 AS DateTime), CAST(0x0000A5F100000000 AS DateTime), 0, N'E002')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (3, CAST(0x0000A59600000000 AS DateTime), CAST(0x0000A59600000000 AS DateTime), 1, N'E002')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (4, CAST(0x0000A59600000000 AS DateTime), CAST(0x0000A59B00000000 AS DateTime), 0, N'E003')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (5, CAST(0x0000A59600000000 AS DateTime), CAST(0x0000A59B00000000 AS DateTime), 1, N'E003')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (12, CAST(0x0000A5E800000000 AS DateTime), CAST(0x0000A5EB00000000 AS DateTime), 1, N'E004')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (13, CAST(0x0000A5E200000000 AS DateTime), CAST(0x0000A5E400000000 AS DateTime), 0, N'E004')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (14, CAST(0x0000A5E900000000 AS DateTime), CAST(0x0000A5EB00000000 AS DateTime), 0, N'E002')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (15, CAST(0x0000A5E900000000 AS DateTime), CAST(0x0000A5EA00000000 AS DateTime), 0, N'E002')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (16, CAST(0x0000A5EF00000000 AS DateTime), CAST(0x0000A5F000000000 AS DateTime), 0, N'E002')
INSERT [dbo].[tbl_leave] ([leaveID], [fromDate], [toDate], [accept], [empID]) VALUES (17, CAST(0x0000A5F000000000 AS DateTime), CAST(0x0000A5F100000000 AS DateTime), 0, N'E003')
SET IDENTITY_INSERT [dbo].[tbl_leave] OFF
/****** Object:  Table [dbo].[tbl_account]    Script Date: 04/14/2016 18:56:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_account](
	[accountID] [nvarchar](20) NOT NULL,
	[password] [nvarchar](20) NOT NULL,
	[role] [int] NOT NULL,
 CONSTRAINT [PK_tbl_account] PRIMARY KEY CLUSTERED 
(
	[accountID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E001', N'123', 1)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E002', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E003', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E004', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E005', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E006', N'123', 1)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E007', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E008', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E009', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E010', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E011', N'123', 1)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E012', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E013', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E014', N'123', 0)
INSERT [dbo].[tbl_account] ([accountID], [password], [role]) VALUES (N'E015', N'123', 0)
/****** Object:  ForeignKey [FK_tbl_employee_tbl_department]    Script Date: 04/14/2016 18:56:37 ******/
ALTER TABLE [dbo].[tbl_employee]  WITH CHECK ADD  CONSTRAINT [FK_tbl_employee_tbl_department] FOREIGN KEY([depID])
REFERENCES [dbo].[tbl_department] ([depID])
GO
ALTER TABLE [dbo].[tbl_employee] CHECK CONSTRAINT [FK_tbl_employee_tbl_department]
GO
/****** Object:  ForeignKey [FK_tbl_employee_tbl_status]    Script Date: 04/14/2016 18:56:37 ******/
ALTER TABLE [dbo].[tbl_employee]  WITH CHECK ADD  CONSTRAINT [FK_tbl_employee_tbl_status] FOREIGN KEY([status])
REFERENCES [dbo].[tbl_status] ([statusID])
GO
ALTER TABLE [dbo].[tbl_employee] CHECK CONSTRAINT [FK_tbl_employee_tbl_status]
GO
/****** Object:  ForeignKey [FK_tbl_leave_tbl_employee]    Script Date: 04/14/2016 18:56:37 ******/
ALTER TABLE [dbo].[tbl_leave]  WITH CHECK ADD  CONSTRAINT [FK_tbl_leave_tbl_employee] FOREIGN KEY([empID])
REFERENCES [dbo].[tbl_employee] ([employeeID])
GO
ALTER TABLE [dbo].[tbl_leave] CHECK CONSTRAINT [FK_tbl_leave_tbl_employee]
GO
/****** Object:  ForeignKey [FK_tbl_account_tbl_employee]    Script Date: 04/14/2016 18:56:37 ******/
ALTER TABLE [dbo].[tbl_account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_account_tbl_employee] FOREIGN KEY([accountID])
REFERENCES [dbo].[tbl_employee] ([employeeID])
GO
ALTER TABLE [dbo].[tbl_account] CHECK CONSTRAINT [FK_tbl_account_tbl_employee]
GO
/****** Object:  ForeignKey [FK_tbl_account_tbl_roles]    Script Date: 04/14/2016 18:56:37 ******/
ALTER TABLE [dbo].[tbl_account]  WITH CHECK ADD  CONSTRAINT [FK_tbl_account_tbl_roles] FOREIGN KEY([role])
REFERENCES [dbo].[tbl_roles] ([role])
GO
ALTER TABLE [dbo].[tbl_account] CHECK CONSTRAINT [FK_tbl_account_tbl_roles]
GO
